package emulater.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

import emulater.application.bean.StorageBean;
import emulater.xml.XmlElementInterface;

public class FileUtil {

    public static String storageDir = "prop/storage/";

    public static XmlElementInterface readProblemFile(Class<? extends XmlElementInterface> clazz, String path) {

        try (
            GZIPInputStream gs = new GZIPInputStream(new BufferedInputStream(new FileInputStream(path)));
            BufferedReader br = new BufferedReader(new InputStreamReader(gs, "UTF-8"));
        ) {

            XmlElementInterface prob = JAXBUtil.getXMLStream(clazz, gs);
            return prob;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static int outputAnswerObject(StorageBean storage) {

        Path path = null;

        try {
            path = Paths.get(storageDir.concat(storage.getName().replaceAll(" ", "")));
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }

            String filename = new StringBuilder(path.toString()).append("/").append(storage.getDay().format(Constant.OUTPUT_FORMAT)).append(".answer").toString();

            path = Paths.get(filename);

            if (!Files.exists(path)) {
                Files.createFile(path);
            } else {
                return 1;
            }

        } catch (IOException e1) {
            e1.printStackTrace();
            return 0;
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {

            oos.writeObject(storage);

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        return 2;

    }

    public static ArrayList<StorageBean> inputAnswerObject() {

        ArrayList<StorageBean> storages = new ArrayList<StorageBean>();

        File files = Paths.get(storageDir).toFile();
        for (File dir : files.listFiles()) {

            for (File f : dir.listFiles()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {

                    storages.add((StorageBean) ois.readObject());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return storages;

    }

}
