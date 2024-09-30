package Creational;

class House {
    private String walls;
    private String roof;
    private String foundation;

    private House(Builder builder) {
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.foundation = builder.foundation;
    }

    public static class Builder {
        private String walls;
        private String roof;
        private String foundation;

        public Builder setWalls(String walls) {
            this.walls = walls;
            return this;
        }

        public Builder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public Builder setFoundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }

    @Override
    public String toString() {
        return "House [Walls=" + walls + ", Roof=" + roof + ", Foundation=" + foundation + "]";
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        House house = new House.Builder()
                .setWalls("Brick")
                .setRoof("Concrete")
                .setFoundation("Wood")
                .build();
        System.out.println(house);
    }
}

//refer explanation.txt for more information