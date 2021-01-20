package com.liai.example;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class LambdaDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("张三");
//        list.add("李四");
//        list.add("王五");
//        list.forEach(System.out::println);
//        System.out.println("================");
//        List<String> strings = list.stream().filter(name -> "张三".equals(name)).collect(Collectors.toList());
//
//        Runnable runnable = () -> {
//            System.out.println("this is runnable");
//            System.out.println("runnable");
//        };
//        System.out.println(strings.get(0));
//        System.out.println("================");
////
////        List<String> sub = new ArrayList<>();
////        for (String name : list) {
////            if (name.equals("张三")) {
////                sub.add(name);
////                continue;
////            }
////           // System.out.println(name);
////        }
////        list.removeAll(sub);
////        System.out.println(list);
//        System.out.println("操作前:" + list);
//        Iterator<String> iterator = list.iterator();
//        String name;
//        while (iterator.hasNext()) {
//            name = iterator.next();
//            if ("张三".equals(name)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(list);
//
//        // HashSet   HashMap
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(11);
//        list1.add(22);
//        list1.add(33);
//        list1.add(44);
//        list1.add(55);
//        list1.add(11);
//        System.out.println(new HashSet<Integer>(list1).size());
//
//        String aa = "jsonObject.getString(\"user_id\");";
//        String s = aa.replaceAll("u(s(er))", "$2");
//
//        boolean matches = Pattern.matches("json.*u(s(er)).*\\);", aa);
//
//        System.out.println(matches);
//        System.out.println(s);
//
//        System.out.println("==================");
//        DemoA a = new DemoA(new DemoB("a"));
//        System.out.println(a.hashCode());
//        DemoA b = new DemoA(new DemoB("a"));
//        System.out.println(b.hashCode());
//
//        Map<DemoA, String> demoMap = new HashMap<>();
//
//        demoMap.put(a, "ab");
//        demoMap.put(b, "b");
//
//        System.out.println(demoMap.size());
//        System.out.println(demoMap.get(a));
        System.out.println(decompress(Paths.get("D:\\tmp\\tmp.zip"), ".log", "most"));
    }


    static class DemoA {
        DemoB demoB;

        public DemoA(DemoB demoB) {
            this.demoB = demoB;
        }

        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            DemoA demoA = (DemoA) o;
//            return Objects.equals(demoB, demoA.demoB);
            return true;
        }


    }

    static class DemoB {
        String a;

        public DemoB(String a) {
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DemoB demoB = (DemoB) o;
            return Objects.equals(a, demoB.a);

        }


    }

    public static List<String> decompress(Path path, String suffix, String str) {
        ZipInputStream zipInputStream = null;
        ZipEntry nextEntry;
        List<String> zipFilePath = new ArrayList<>();
        try {
            zipInputStream = new ZipInputStream(Files.newInputStream(path));
            zipFilePath.addAll(decompressZipInputStream(suffix, str, zipInputStream));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(zipInputStream)) {
                try {
                    zipInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return zipFilePath;
    }

    private static List<String> decompressZipInputStream(String suffix, String str, ZipInputStream zipInputStream) throws IOException {
        List<String> zipFilePath = new ArrayList<>();
        ZipEntry nextEntry;
        nextEntry = zipInputStream.getNextEntry();

        while (Objects.nonNull(nextEntry)) {
            if (nextEntry.isDirectory()) {
                nextEntry = zipInputStream.getNextEntry();
                continue;
            } else if (nextEntry.getName().endsWith(".zip")) {
                ZipInputStream subZipInputStream = new ZipInputStream(zipInputStream);
                decompressZipInputStream(suffix, str, subZipInputStream);
                subZipInputStream.closeEntry();

            } else if (nextEntry.getName().endsWith(suffix)) {
                if (findStr(zipInputStream, str)) {
                    zipFilePath.add(nextEntry.getName());
                }
            }
            System.out.println(nextEntry.getName());
            nextEntry = zipInputStream.getNextEntry();
        }
        return zipFilePath;
    }


    public static boolean findStr(ZipInputStream zipInputStream, String str) {

        //System.out.println(nextEntry.getName());
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            len = zipInputStream.read(bytes, 0, bytes.length);

            while (len != -1) {
                stringBuffer.append(new String(bytes, 0, len));
                bytes = new byte[1024];
                len = zipInputStream.read(bytes, 0, bytes.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                zipInputStream.closeEntry();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (stringBuffer.indexOf(str) != -1) {
            return true;
        }
        return false;
    }
}
