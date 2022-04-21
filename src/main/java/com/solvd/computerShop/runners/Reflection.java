package com.solvd.computerShop.runners;


import com.solvd.computerShop.enums.GenderType;
import com.solvd.computerShop.person.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.IntStream;

public class Reflection {

    private static final Logger LOGGER = LogManager.getLogger(Reflection.class.getName());

    public static void main(String[] args) {
        try {
            Class cls = Class.forName("com.solvd.computerShop.person.Employee");

            //Field list of Employee class
            LOGGER.debug("-ATTRIBUTES------------------------------------");
            Field fieldlist[] = cls.getDeclaredFields();
            IntStream.range(0, fieldlist.length).forEach(i -> {
                Field fld = fieldlist[i];
                int mod = fld.getModifiers();
                LOGGER.debug("NAME= " + fld.getName()
                        + " DECL CLASS = " + fld.getDeclaringClass()
                        + " TYPE = " + fld.getType()
                        + " MODIFIERS = " + Modifier.toString(mod));
            });

            //Methdo list of DesktopComputer class
            LOGGER.debug("-METHODS---------------------------------------");
            Method m[] = cls.getDeclaredMethods();
            IntStream.range(0, m.length).forEach(i -> {
                LOGGER.debug(m[i].toString());
            });

            LOGGER.debug("-----------------------------------------------");

            //Creating new instance using reflection
            Constructor<Employee> constructor = cls.getConstructor(String.class, String.class, String.class, int.class, Enum.class, int.class, int.class, boolean.class);
            Employee employee = constructor.newInstance("Juan", "Acosta", "31344566", 29, GenderType.MALE, 0003, 2500, true);
            LOGGER.debug("\nConstructor parameters count: " + constructor.getParameterCount());

            //Calling methods using reflection
            Method working = cls.getMethod("working");
            working.invoke(employee);

        } catch (Throwable e) {
            LOGGER.info(e.getMessage());
        }
    }
}
