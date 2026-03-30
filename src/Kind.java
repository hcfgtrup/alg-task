import java.util.Scanner;

public enum Kind {
    CIRCLE("Круг"){
        @Override
        public AbstractFigure createFigure(Scanner scanner) {
            double radius;
            while (true) {
                System.out.println("Радиус: ");
                radius = scanner.nextDouble();
                if (radius > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: Радиус должен быть положительным, повторите ввод");
                }
            }
            return new Circle(radius);
        }
    },

    RECTANGLE("Прямоугольник"){
        @Override
        public AbstractFigure createFigure(Scanner scanner) {
            double width;
            while (true) {
                System.out.println("Ширина прямоугольника: ");
                width = scanner.nextDouble();
                if (width > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: Ширина должна быть положительной, повторите ввод");
                }
            }

            double length;
            while(true){
                System.out.println("Длина прямоугольника: ");
                length = scanner.nextDouble();
                if (length >= width){
                    break;
                }else{
                    System.out.println("Ошибка: Длина не может быть меньше ширины, повторите ввод");
                }
            }

            if (Math.abs(width - length) < 0.0001) {
                return new Square(width);
            } else {
                return new Rectangle(width, length);
            }
        }
    },

    SQUARE("Квадрат"){
        @Override
        public AbstractFigure createFigure(Scanner scanner){

            double side;
            while (true){
                System.out.println("Сторона: ");
                side = scanner.nextDouble();
                if(side>0){
                    break;
                } else {
                    System.out.println("Ошибка: Длина стороны квадрата не может быть отрицательной, повторите ввод");
                }
            }
            return new Square(side);
        }
    },

    TRIANGLE("Треугольник"){
        @Override
        public AbstractFigure createFigure(Scanner scanner) {
            Triangle triangle;
            while (true) {

                double side_a;
                while (true) {
                    System.out.println("Сторона а: ");
                    side_a = scanner.nextDouble();
                    if (side_a > 0) {
                        break;
                    } else {
                        System.out.println("Ошибка: Длина стороны тругольника не может быть отрицательной, повторите ввод");
                    }
                }

                double side_b;
                while (true) {
                    System.out.println("Сторона b: ");
                    side_b = scanner.nextDouble();
                    if (side_b > 0) {
                        break;
                    } else {
                        System.out.println("Ошибка: Длина стороны тругольника не может быть отрицательной, повторите ввод");

                    }
                }

                double side_c;
                while (true) {
                    System.out.println("Сторона c: ");
                    side_c = scanner.nextDouble();
                    if (side_c > 0) {
                        break;
                    } else {
                        System.out.println("Ошибка: Длина стороны тругольника не может быть отрицательной, повторите ввод");
                    }
                }

                triangle = new Triangle(side_a, side_b, side_c);
                if (triangle.existence()) {
                    break;
                } else {
                    System.out.println("Ошибка: Треугольника с такими сторонами не существует, повторите ввод");
                }
            }
            return triangle;
        }
    };

    private final String russian_name;

    Kind(String russian_name) {
        this.russian_name = russian_name;
    }

    public String getRussianName() {
        return russian_name;
    }

    public abstract AbstractFigure createFigure(Scanner scanner);

    public static Kind fromRussianName(String name) {
        for (Kind kind : values()) {
            if (kind.russian_name.equalsIgnoreCase(name)) {
                return kind;
            }
        }
        return null;
    }

    public void process(Scanner scanner){
        AbstractFigure figure = createFigure(scanner);
        if (figure instanceof Square) {
            System.out.println("Квадрат");
        } else {
            System.out.println(getRussianName());
        }
        figure.Output();
    }
}
