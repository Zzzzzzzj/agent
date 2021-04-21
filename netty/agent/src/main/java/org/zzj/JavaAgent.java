package org.zzj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;

/**
 * @auther: stan
 * @create: 2021-04-21 14:14
 */
public class JavaAgent {


    public static void agentmain(String args, Instrumentation inst) throws Exception {
        System.out.println("agent启动成功，开发重定义对象....");
        Class<?>[] allClass = inst.getAllLoadedClasses();
        for (Class<?> c : allClass) {
            System.out.println(c.getName());
            if (c.getName().endsWith("Test")) {
                //todo
                String pathName = "C:/Users/Administrator/IdeaProjects/netty/test/target/classes/org/zzj/Test.class";
                File file = new File(pathName);
                try {
                    byte[] bytes = fileToBytes(file);
                    System.out.println("文件大小:" + bytes.length);
                    ClassDefinition classDefinition = new ClassDefinition(c, bytes);
                    inst.redefineClasses(classDefinition);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("转化代码");
            }
        }
        System.out.println("热更新完成");
    }


    public static byte[] fileToBytes(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        return bytes;

    }

}
