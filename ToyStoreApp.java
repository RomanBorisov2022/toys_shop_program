import java.util.List;

public class ToyStoreApp {
    public static void main(String[] args) {
        ToyList toyList = new ToyList();
        String toyData = "1,Кукла,5,10\r\n" + "2,Машинка,10,15\r\n" + "3,Мяч,15,20\r\n" + "4,Конструктор,7,25\r\n"
                + "5,Кубики,20,30\r\n";
        for (String toy : toyData.split("\r\n")) {
            String[] toyArray = toy.split(",");
            int id = Integer.parseInt(toyArray[0]);
            String name = toyArray[1];
            int quantity = Integer.parseInt(toyArray[2]);
            double weight = Double.parseDouble(toyArray[3]);
            toyList.addNewToy(new Toy(id, name, quantity, weight), 0);
        }

        PrizeToyList prizeToyList = new PrizeToyList();

        Toy chosenToy = toyList.chooseToy();
        System.out.println("Выбрана игрушка: " + chosenToy.getName());

        // Получаем призовую игрушку и записываем в файл
        PrizeToy prizeToy = new PrizeToy(chosenToy.getId(), chosenToy.getName(), 1, chosenToy.getWeight());
        prizeToyList.addPrizeToy(prizeToy);
        Toy updatedToy = new Toy(chosenToy.getId(), chosenToy.getName(), chosenToy.getQuantity() - 1, chosenToy.getWeight());
        toyList.removeToy(chosenToy);
        toyList.addNewToy(updatedToy, 0);

        // Добавляем новую игрушку с весом 10%
        Toy newToy = new Toy(6, "Плюшевый мишка", 2, 10);
        toyList.addNewToy(newToy, 10);

        // Меняем вес игрушки
        Toy toyToModify = toyList.getToy(1);
        toyList.modifyWeight(toyToModify, 50);

        List<Toy> toys = toyList.getToys();
        for (Toy toy : toys) {
            System.out.println(toy.getId() + ", " + toy.getName() + ", " + toy.getQuantity() + ", " + toy.getWeight());
        }

        List<PrizeToy> prizeToys = prizeToyList.getPrizeToys();
        for (PrizeToy prize : prizeToys) {
            System.out.println("Призовая игрушка: " + prize.getName() + ", количество: " + prize.getQuantity() + ", вес: " + prize.getWeight());
        }
    }
}