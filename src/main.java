import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean carrierPlaced=false, battleshipPlaced=false, submarinePlaced=false, cruiserPlaced=false, destroyerPlaced=false;
        String startCoordinate, endCoordinate;

        String[][] battleshipGrid = makingGrid();
        displayingGrid(battleshipGrid);

        while (!carrierPlaced) {
            System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells)");
            startCoordinate = input.next().toUpperCase();
            endCoordinate = input.next().toUpperCase();
            carrierPlaced = takingCoordinates(startCoordinate, endCoordinate, 5, "Aircraft Carrier", false, battleshipGrid);
            if (carrierPlaced)
                battleshipGrid = updateGrid(startCoordinate, endCoordinate, battleshipGrid);
        }
        displayingGrid(battleshipGrid);
        while (!battleshipPlaced) {
            System.out.println("Enter the coordinates of the Battleship (4 cells)");
            startCoordinate = input.next().toUpperCase();
            endCoordinate = input.next().toUpperCase();
            battleshipPlaced = takingCoordinates(startCoordinate, endCoordinate, 4, "Battleship", false,battleshipGrid);
            if (battleshipPlaced)
                battleshipGrid = updateGrid(startCoordinate, endCoordinate, battleshipGrid);
        }
        displayingGrid(battleshipGrid);
        while (!submarinePlaced) {
            System.out.println("Enter the coordinates of the Submarine (3 cells)");
            startCoordinate = input.next().toUpperCase();
            endCoordinate = input.next().toUpperCase();
            submarinePlaced = takingCoordinates(startCoordinate, endCoordinate, 3, "Submarine", false, battleshipGrid);
            if (submarinePlaced)
                battleshipGrid = updateGrid(startCoordinate, endCoordinate, battleshipGrid);
        }
        displayingGrid(battleshipGrid);
        while (!cruiserPlaced) {
            System.out.println("Enter the coordinates of the Cruiser (3 cells)");
            startCoordinate = input.next().toUpperCase();
            endCoordinate = input.next().toUpperCase();
            cruiserPlaced = takingCoordinates(startCoordinate, endCoordinate, 3, "Cruiser", false, battleshipGrid);
            if (cruiserPlaced)
                battleshipGrid = updateGrid(startCoordinate, endCoordinate, battleshipGrid);
        }
        displayingGrid(battleshipGrid);
        while (!destroyerPlaced) {
            System.out.println("Enter the coordinates of the Destroyer (2 cells)");
            startCoordinate = input.next().toUpperCase();
            endCoordinate = input.next().toUpperCase();
            destroyerPlaced = takingCoordinates(startCoordinate, endCoordinate, 2, "Destroyer", false, battleshipGrid);
            if (destroyerPlaced)
                battleshipGrid = updateGrid(startCoordinate, endCoordinate, battleshipGrid);
        }
        displayingGrid(battleshipGrid);
    }

    public static String[][] makingGrid() {
        String[][] battleshipGrid = new String[11][11];
        for (int row=0; row<11; row++) {
            for (int column=0; column<11; column++) {
                if (row==0 && column==0)
                    battleshipGrid[row][column] = "  ";

                else if (row==0 && column!=0)
                    battleshipGrid[row][column] = column+" ";

                else if (row>0 && column==0)
                    battleshipGrid[row][column] = Character.toString(row+64);

                else
                    battleshipGrid[row][column] = " ~";
            }
        }
        return battleshipGrid;
    }

    public static void displayingGrid(String[][] battleshipGrid) {
        for (String[] row : battleshipGrid) {
            for (String column : row) {
                System.out.print(column);
            }
            System.out.println("");
        }
    }

    public static boolean takingCoordinates(String startCoordinate, String endCoordinate, int size, String type, boolean shipPlaced, String[][] battleshipGrid) {
        int startingX, startingY, endingX, endingY;
        startingX = startCoordinate.charAt(0)-64;
        if (startCoordinate.length() == 3)
            startingY = Integer.parseInt(String.valueOf(startCoordinate.charAt(1)).concat(String.valueOf(startCoordinate.charAt(2))));
        else
            startingY = Integer.parseInt(String.valueOf(startCoordinate.charAt(1)));
        endingX = endCoordinate.charAt(0)-64;
        if (endCoordinate.length() == 3)
        endingY = Integer.parseInt(String.valueOf(endCoordinate.charAt(1)).concat(String.valueOf(endCoordinate.charAt(2))));
        else
            endingY = Integer.parseInt(String.valueOf(endCoordinate.charAt(1)));
        if (startingX == endingX) {
            if (startingY-endingY==size-1 || endingY-startingY==size-1) {
                shipPlaced = true;
                /*if (startingY<endingY) {
                    for (int y=startingY; y<=endingY; y++) {
                        if (battleshipGrid[startingX][y].equals(" O") || battleshipGrid[startingX + 1][y].equals(" O")
                                || battleshipGrid[startingX - 1][y].equals(" O") || battleshipGrid[startingX][y + 1].equals(" O")
                                || battleshipGrid[startingX][y - 1].equals(" O")) {
                            shipPlaced = false;
                            break;
                        }
                    }
                }
                else {
                    for (int y=endingY; y<=startingY; y++) {
                        if (battleshipGrid[startingX][y].equals(" O") || battleshipGrid[startingX + 1][y].equals(" O")
                                || battleshipGrid[startingX - 1][y].equals(" O") || battleshipGrid[startingX][y + 1].equals(" O")
                                || battleshipGrid[startingX][y - 1].equals(" O")) {
                            shipPlaced = false;
                            break;
                        }
                    }
                }*/
                if (!shipPlaced) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            }
            else
                System.out.printf("Error! Wrong length of the %s! Try again:\n\n", type);
        }
        else if (startingY == endingY) {
            if (startingX-endingX==size-1 || endingX-startingX==size-1) {
                shipPlaced = true;
                /*if (startingX<endingX) {
                    for (int x=startingX; x<=endingX; x++) {
                        if (battleshipGrid[x][startingY].equals(" O") || battleshipGrid[x][startingY + 1].equals(" O")
                                || battleshipGrid[x][startingY - 1].equals(" O") || battleshipGrid[x + 1][startingY].equals(" O")
                                || battleshipGrid[x - 1][startingY].equals(" O")) {
                            shipPlaced = false;
                            break;
                        }
                    }
                }
                else {
                    for (int x=endingX; x<=startingX; x++) {
                        if (battleshipGrid[x][startingY].equals(" O") || battleshipGrid[x][startingY + 1].equals(" O")
                                || battleshipGrid[x][startingY - 1].equals(" O") || battleshipGrid[x + 1][startingY].equals(" O")
                                || battleshipGrid[x - 1][startingY].equals(" O")) {
                            shipPlaced = false;
                            break;
                        }
                    }
                }*/
                if (!shipPlaced) {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            }
            else
                System.out.printf("Error! Wrong length of the %s! Try again:\n\n", type);
        }
        else
            System.out.println("Error! Wrong ship location! Try again:\n");
        return shipPlaced;
    }

    public static String[][] updateGrid(String startCoordinate, String endCoordinate, String[][] battleshipGrid) {
        int startingX, startingY, endingX, endingY;
        startingX = startCoordinate.charAt(0)-64;
        if (startCoordinate.length() == 3)
            startingY = Integer.parseInt(String.valueOf(startCoordinate.charAt(1)).concat(String.valueOf(startCoordinate.charAt(2))));
        else
            startingY = Integer.parseInt(String.valueOf(startCoordinate.charAt(1)));
        endingX = endCoordinate.charAt(0)-64;
        if (endCoordinate.length() == 3)
            endingY = Integer.parseInt(String.valueOf(endCoordinate.charAt(1)).concat(String.valueOf(endCoordinate.charAt(2))));
        else
            endingY = Integer.parseInt(String.valueOf(endCoordinate.charAt(1)));

        if (startingY<endingY) {
            for (int y=startingY; y<=endingY; y++) {
                battleshipGrid[startingX][y] = " O";
            }
        }
        else if (startingY>endingY) {
            for (int y=endingY; y<=startingY; y++) {
                battleshipGrid[startingX][y] = " O";
            }
        }
        else if (startingX<endingX) {
            for (int x=startingX; x<=endingX; x++) {
                battleshipGrid[x][startingY] = " O";
            }
        }
        else if (startingX>endingX) {
            for (int x=endingX; x<=startingX; x++) {
                battleshipGrid[x][startingY] = " O";
            }
        }
        return battleshipGrid;
    }
}