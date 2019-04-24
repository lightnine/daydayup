package com.leon.effectiveJava.Item2;

/**
 * @Author leon
 * @Date 2019/4/16 20:19
 * 展示如何实现Builder模式
 * 1. 构造Builder静态成员类
 * 2. NutritionFacts必填的参数，构造对应的Builder构造器方法
 * 3. 提供builder方法，返回NutritionFacts实例
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 必须填写的参数
        private final int servingSize;
        private final int servings;
        // 可选的参数
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).fat(10).build();
        // 在本类中可以调用calories,但是在其他类中就调用不了，因为是private的
        System.out.println("calories:" + cocaCola.calories);
    }
}
