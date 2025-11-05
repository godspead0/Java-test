package javaProgramming.demo14;

/**
 * 数组工具类，包含查找最大值的泛型方法
 */
public class ArrayUtils {

    /**
     * 泛型方法：查找数组中的最大值
     * @param <T> 数组元素的类型，必须实现Comparable接口
     * @param array 任意类型的数组
     * @return 数组中的最大值
     * @throws IllegalArgumentException 如果数组为空或长度为0
     */
    public static <T extends Comparable<T>> T findMax(T[] array) {
        // 检查数组是否为空或长度为0
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空且长度必须大于0");
        }
        // 初始化最大值为数组的第一个元素
        T max = array[0];
        // 遍历数组，比较每个元素与当前最大值
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 重载方法：支持基本数据类型的int数组
     * @param array int数组
     * @return 数组中的最大值
     * @throws IllegalArgumentException 如果数组为空或长度为0
     */
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空且长度必须大于0");
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 重载方法：支持基本数据类型的double数组
     * @param array double数组
     * @return 数组中的最大值
     * @throws IllegalArgumentException 如果数组为空或长度为0
     */
    public static double findMax(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空且长度必须大于0");
        }

        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}