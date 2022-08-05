package com.l3vi.multidatasource;

import java.util.Stack;

/**
 * @author 996kid@gmail.com
 * @Description DataSourceStackContextHolder
 * @Date 2022/5/27 11:01
 */
public class DataSourceStackContextHolder {

    private static ThreadLocal<Stack<SourceTypeEnum>> datasourceStack = new ThreadLocal<>();

    public static void push(SourceTypeEnum sourceType) {
        if (datasourceStack.get() != null) {
            datasourceStack.get().push(sourceType);
        } else {
            Stack<SourceTypeEnum> stack = new Stack<>();
            stack.push(sourceType);
            datasourceStack.set(stack);
        }
    }

    public static SourceTypeEnum pop() {
        SourceTypeEnum sourceTypeEnum = datasourceStack.get().pop();
//        if (datasourceStack.get().size() == 0) {
//            datasourceStack.remove();
//        }
        return sourceTypeEnum;
    }

    public static SourceTypeEnum peek() {
        return datasourceStack.get().peek();
    }
}
