package com.ease.architecture.util;

import java.io.*;


/**
 * mybatis二级缓存的序列化工具类
 * 这里使用简单的jdk序列化来完成相关工作
 * 在实际使用过程嗯中可以使用其他序列化工具进行代替
 */
public class SerializableTools {

    /**
     * 反序列化
     *
     * @param bt
     * @return
     * @throws IOException
     * @throws Exception
     */

    public static Object byteArrayToObj(byte[] bt) throws Exception {

        ByteArrayInputStream bais = new ByteArrayInputStream(bt);

        ObjectInputStream ois = new ObjectInputStream(bais);

        return ois.readObject();

    }


    /**
     * 对象序列化
     *
     * @param obj
     * @return
     * @throws IOException
     */

    public static byte[] ObjToByteArray(Object obj) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(obj);

        return bos.toByteArray();

    }
}
