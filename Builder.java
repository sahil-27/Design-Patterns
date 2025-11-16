/**
 * Builder Pattern separates the construction of a complex object from its representation,
 * allowing the same construction process to create different representations.
 * It is particularly useful when an object needs to be created with many possible configurations.
 */


class House {
    private int rooms;        
    private int floors;
    private boolean swimmingPool;
    private boolean garage;   

    private House(HouseBuilder builder) {
        this.rooms = builder.rooms;
        this.floors = builder.floors;
        this.swimmingPool = builder.swimmingPool;
        this.garage = builder.garage;
    }

    public static class HouseBuilder {
        private int rooms;    
        private int floors;
        private boolean swimmingPool;
        private boolean garage; 

        public HouseBuilder(int cnt) {
            this.rooms = cnt;
        }
        
        public HouseBuilder floors(int cnt) {
            this.floors = cnt;
            return this;
        }
        
        public HouseBuilder pool(boolean pool) {
            this.swimmingPool = pool;
            return this;
        }
        
        public HouseBuilder garage(boolean garage) {
            this.garage = garage;
            return this;
        }

        public House build() {
            return new House(this);
        } 
    }
}

class HouseDirector {  
    public House buildLuxuryHouse() {  
        return new House.HouseBuilder(8)
                .floors(3)
                .pool(true)
                .garage(true)
                .build();
    }

    public House buildSmallHouse() {
        return new House.HouseBuilder(3)
                .floors(1)
                .pool(false)
                .garage(false)
                .build();
    }
}

public class Main {
    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();
        
        House luxury = director.buildLuxuryHouse();
        House small = director.buildSmallHouse();

        House custom = new House.HouseBuilder(4)
                        .floors(2)
                        .pool(true)
                        .garage(true)
                        .build();
    }
}