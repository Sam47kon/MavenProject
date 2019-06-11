package StepikTasks.Stepik5.S5_1;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class ClassFile {

    public static void main(String[] args) {
//        info();
//        printFoldersAndFilesNamesForStandardDir();
//        createAndDelete();
//        moveFolder();
//        new ClassFile().getConfigPath();

        File dir = new File(System.getProperty("user.dir"));
        String[] strings = new String[0];

        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    if (item.getName().contains("src")) {
                        File main = new File(item, "main");
                        if (main.exists()) {
                            File java = new File(main, "java");
                            if (java.exists()) {
                                strings = getFoldersAndFilesNames(java);
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(strings));
    }

    private void getConfigPath() {
        String absolute = getClass().getProtectionDomain().getCodeSource().getLocation().toExternalForm();
        absolute = absolute.substring(0, absolute.length() - 1);
        absolute = absolute.substring(0, absolute.lastIndexOf("/") + 1);
        String configPath = absolute + "config/file.properties";
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            configPath = configPath.replace("/", "\\\\");
            if (configPath.contains("file:\\\\")) {
                configPath = configPath.replace("file:\\\\", "");
            }
        } else if (configPath.contains("file:")) {
            configPath = configPath.replace("file:", "");
        }
        System.out.println("configPath = " + configPath);
    }

    public static void moveFolder() {
        File dir = new File("C:\\Users\\Alina\\Desktop\\FolderWithFiles");
        dir.renameTo(new File("C:\\FolderWithFiles"));
    }

    private static void createAndDelete() {
        // определяем объект для каталога
        File dir = new File("C:\\Users\\Alina\\Desktop\\New Folder");
        boolean created = dir.mkdir();
        if (created) {
            System.out.println("Folder has been created");
        }
        // переименуем каталог
        dir.renameTo(new File("C:\\NewDirRenamed"));
        // удалим каталог
        boolean deleted = dir.delete();
        if (deleted) {
            System.out.println("Folder has been deleted");
        }
    }

    private static void printFoldersAndFilesNamesForStandardDir() {
        // определяем объект для каталога
        String property = System.getProperty("user.dir");
        File dir = new File(property);
        System.out.println("System.getProperty(\"user.dir\") = " + dir);
        System.out.println("new File(\".\") = " + dir.getAbsolutePath());
        // если объект представляет каталог
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \t folder");
                } else {
                    System.out.println(item.getName() + "\t file");
                }
            }
        }
    }


    private static String[] getFoldersAndFilesNames(File dir) {
        String[] dataBase = new String[dir.listFiles().length];
        int i = dataBase.length - 1;
        int j = 0;
        for (File item : dir.listFiles()) {
            if (item.exists()) {
                if (item.isDirectory()) {
                    dataBase[j++] = item.getName();
                } else {
                    dataBase[i--] = item.getName();
                }
            }
        }
        return dataBase;
    }

    private static void info() {
        File dir1 = new File("C:\\Users\\Alina\\Desktop\\Files");
        File dir2 = new File("C:\\Users\\Alina\\Desktop\\Files2");
        File file1 = new File(dir1, "Hello1.txt");
        File file2 = new File("C:\\Users\\Alina\\Desktop\\Files", "Hello2.txt");

        System.out.println("dir1.exists() = " + dir1.exists());
        System.out.println("file1.exists() = " + file1.exists());
        System.out.println("file2.exists() = " + file2.exists());

        System.out.println("dir1.isFile() = " + dir1.isFile());
        System.out.println("file1.isFile() = " + file1.isFile());
        System.out.println("file2.isFile() = " + file2.isFile());

        System.out.println("dir1.isAbsolute() = " + dir1.isAbsolute());
        System.out.println("file1.isAbsolute() = " + file1.isAbsolute());
        System.out.println("file2.isAbsolute() = " + file2.isAbsolute());

        System.out.println("dir1.isDirectory() = " + dir1.isDirectory());
        System.out.println("file1.isDirectory() = " + file1.isDirectory());
        System.out.println("file2.isDirectory() = " + file2.isDirectory());

        System.out.println("dir1.isHidden() = " + dir1.isHidden());
        System.out.println("file1.isHidden() = " + file1.isHidden());
        System.out.println("file2.isHidden() = " + file2.isHidden());

        System.out.println("dir1.getName() = " + dir1.getName());
        System.out.println("file1.getName() = " + file1.getName());
        System.out.println("file2.getName() = " + file2.getName());

        System.out.println("dir1.getParent() = " + dir1.getParent());
        System.out.println("file1.getParent() = " + file1.getParent());
        System.out.println("file2.getParent() = " + file2.getParent());

        System.out.println("dir1.getAbsolutePath() = " + dir1.getAbsolutePath());
        System.out.println("file1.getAbsolutePath() = " + file1.getAbsolutePath());
        System.out.println("file2.getAbsolutePath() = " + file2.getAbsolutePath());

        System.out.println("dir1.getAbsoluteFile() = " + dir1.getAbsoluteFile());
        System.out.println("file1.getAbsoluteFile() = " + file1.getAbsoluteFile());
        System.out.println("file2.getAbsoluteFile() = " + file2.getAbsoluteFile());

        System.out.println("dir1.length() = " + dir1.length());
        System.out.println("file1.length() = " + file1.length());
        System.out.println("file2.length() = " + file2.length());

        System.out.println("dir1.lastModified() = " + dir1.lastModified());
        System.out.println("file1.lastModified() = " + file1.lastModified());
        System.out.println("file2.lastModified() = " + file2.lastModified());

        System.out.println("dir1.setLastModified(111111) = " + dir1.setLastModified(0));
        System.out.println("file1.setLastModified(111111) = " + file1.setLastModified(0));
        System.out.println("file2.setLastModified(111111) = " + file2.setLastModified(0));

        System.out.println("new Date(file2.lastModified()) = " + new Date(file2.lastModified()));

        System.out.println("dir1.mkdir() = " + dir1.mkdir());
        System.out.println("dir1.renameTo(dir2) = " + dir1.renameTo(dir2));
    }
}

