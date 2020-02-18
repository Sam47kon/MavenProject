package JavaHeadFirstAndOther.OOP;

import java.util.Arrays;

public class TemplateBuilder {    //шаблон Builder


    public static void main(String[] args) {
        GoodClass goodClass = new GoodClass.Builder(1, 2)
                .optFieldOne(11)
                .optFieldTwo(22)
                .optFieldThird(23)
                .optFieldFour(24)
                .build();

        System.out.println(goodClass.toString());

        GoodClass myClass1 = new GoodClass.Builder(1, 2).build();
        System.out.println(myClass1.toString());

        GoodClass myClass2 = new GoodClass.Builder(11, 22)
                .optFieldOne(111)
                .optFieldTwo(222)
                .optFieldThird(333)
                .build();
        System.out.println(myClass2.toString());

    }

    static class GoodClass {
        private final int reqFieldOne;     // обязательный
        private final int reqFieldTwo;     // обязательный
        private final int optFieldOne;     // необязательный
        private final int optFieldTwo;     // необязательный
        private final int optFieldThird;   // необязательный
        private final int optFieldFour;    // необязательный

        private GoodClass(Builder builder) {
            reqFieldOne = builder.reqFieldOne;
            reqFieldTwo = builder.reqFieldTwo;
            optFieldOne = builder.optFieldOne;
            optFieldTwo = builder.optFieldTwo;
            optFieldThird = builder.optFieldThird;
            optFieldFour = builder.optFieldFour;
        }

        public String toString() {
            int[] arr = {reqFieldOne, reqFieldTwo, optFieldOne, optFieldTwo, optFieldThird, optFieldFour};
            return Arrays.toString(arr);
        }

        static class Builder {
            // Обязательные параметры
            private final int reqFieldOne;
            private final int reqFieldTwo;

            // Необязательные параметры с значениями по умолчанию
            private int optFieldOne = 0;
            private int optFieldTwo = 0;
            private int optFieldThird = 0;
            private int optFieldFour = 0;

            Builder(int reqFieldOne, int reqFieldTwo) {
                this.reqFieldOne = reqFieldOne;
                this.reqFieldTwo = reqFieldTwo;
            }

            Builder optFieldOne(int val) {
                optFieldOne = val;
                return this;
            }

            Builder optFieldTwo(int val) {
                optFieldTwo = val;
                return this;
            }

            Builder optFieldThird(int val) {
                optFieldThird = val;
                return this;
            }

            Builder optFieldFour(int val) {
                optFieldFour = val;
                return this;
            }

            GoodClass build() {
                return new GoodClass(this);
            }
        }
    }
}
