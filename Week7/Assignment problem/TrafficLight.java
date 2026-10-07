public class TrafficLight {
    private final String id;      // Fixed ID set upon creation
    private String color;         // Private state for current color

    // Constructor initializing ID and default starting color "RED"
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // A new light starts on RED
    }

    // Cycles to the next color in sequence: RED -> GREEN -> YELLOW -> RED
    public void next() {
    this.color = switch (color) {
        case "RED" -> "GREEN";
        case "GREEN" -> "YELLOW";
        case "YELLOW" -> "RED";
        default -> "RED";
    };
}
    // Read-only getter for the current color
    public String getColor() {
        return color;
    }

    // Read-only getter for the light ID
    public String getId() {
        return id;
    }
}
