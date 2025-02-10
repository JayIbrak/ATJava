package Lesson30;

public class PartB {
    abstract class Sensor {
        private String name;
        private int modelNumber;

        public Sensor(String name, int modelNumber) {
            this.name = name;
            this.modelNumber = modelNumber;
        }

        public String getName() {
            return name;
        }

        public int getModelNumber() {
            return modelNumber;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setModelNumber(int modelNumber) {
            this.modelNumber = modelNumber;
        }

        public abstract void recordMeasurement();

    }
}
