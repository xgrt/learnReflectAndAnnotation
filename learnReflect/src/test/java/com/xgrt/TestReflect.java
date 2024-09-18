package com.xgrt;

import com.xgrt.domain.Cat;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {

    @Test
    public void testReflect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class c = Cat.class;
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "--->" + constructor.getParameterCount());
        }

        Constructor constructor4=c.getDeclaredConstructor(int.class,String.class);//获取参数为String类型和int类型的构造器（只要有就行）
        System.out.println(constructor4.getName());

        constructor4.setAccessible(true);
        Object cat1=constructor4.newInstance(5,"加菲猫");//一般不建议强转
        System.out.println(cat1);

        Field[] fields = c.getDeclaredFields();//获取多个成员变量，推荐使用。

        for(Field field:fields){
            System.out.println(field.getName()+ " " + field.getType());
        }

        Field fName = c.getDeclaredField("name");//获取单个成员变量，推荐使用。
        System.out.println(fName.getName()+ "-->" + fName.getType());

        Field fAge = c.getDeclaredField("age");
        System.out.println(fAge.getName()+ "-->" + fAge.getType());

        Cat cat=new Cat();
        fName.setAccessible(true);// 禁止检查访问控制权限
        fName.set(cat,"狸花猫");//赋值
        System.out.println(cat);

        String name = (String) fName.get(cat);//取值
        System.out.println(name);

        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName()+
                    "-->"+method.getParameterCount()+
                    "-->"+method.getReturnType());
        }

        Method go=c.getDeclaredMethod("go");//go方法无参
        System.out.println(go.getName()+
                "-->"+go.getParameterCount()+
                "-->"+go.getReturnType());

        Method sayHello=c.getDeclaredMethod("sayHello",String.class);
        System.out.println(sayHello.getName()+
                "-->"+sayHello.getParameterCount()+
                "-->"+sayHello.getReturnType());

        go.setAccessible(true);
        Object rs = go.invoke(cat);
        System.out.println(rs);

        sayHello.setAccessible(true);
        Object rs2 = sayHello.invoke(cat, "xgrt");
        System.out.println(rs2);

    }

}
