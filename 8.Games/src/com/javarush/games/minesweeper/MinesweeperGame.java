package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_16;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private static final String MINE = "\uD83D\uDCA3"; //new String("\uD83D\uDCA3".getBytes(), UTF_16);
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped/* = true*/;
    private int countClosedTiles = SIDE * SIDE;
    private int score;

    @Override
    public void initialize(){
        setScreenSize(SIDE, SIDE); //размер игрового поля
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y){
        if (isGameStopped) {
            restart();
            return;
        }
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y){
        markTile(x, y);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You win!", Color.BROWN, 20);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;

        setScore(score);
        createGame();
    }

    private void openTile(int x, int y){        //
//        if (!(isGameStopped == true)||(!gameField[y][x].isFlag)||(!gameField[y][x].isOpen)) return;
//            if (gameField[x][y].isMine) {
//                //6. В методе openTile(int, int), если объект является миной, должна отрисовываться мина на красном фоне
//                // (используй метод setCellValueEx(int, int, Color, String)) и вызываться метод gameOver().
//                setCellValueEx(x, y, Color.RED, MINE);
//                setCellColor(x, y, Color.RED);
//                gameField[x][y].isOpen = true;
//                countClosedTiles--;
//                gameOver();
//                return;
//            } else if (gameField[x][y].countMineNeighbors == 0) {
//                setCellValue(x, y, "");
//                setCellColor(x, y, Color.GREEN);
//                gameField[x][y].isOpen = true;
//                countClosedTiles--;
//                List<GameObject> neighbors = getNeighbors(gameField[x][y]);
//                for (GameObject gameObject : neighbors) {
//                    if (!gameObject.isOpen) {
//    //                    setCellColor(x, y, Color.GREEN);
//    //                    gameField[x][y].isOpen = true;
//                        openTile(gameObject.y, gameObject.x);
//                    }
//
//                }
//            } else {
//                setCellNumber(x, y, gameField[x][y].countMineNeighbors);
//                setCellColor(x, y, Color.GREEN);
//                gameField[x][y].isOpen = true;
//                countClosedTiles--;
//            } if (countClosedTiles==countMinesOnField){ //вызывать метод win(), если количество не открытых ячеек равно количеству мин на поле,
//            // и последняя открытая ячейка не является миной.
//            win();
//            return;
//        }
        if (gameField[y][x].isOpen || gameField[y][x].isFlag || isGameStopped) return;
        gameField[y][x].isOpen = true;
        countClosedTiles--;
        score +=5;
        setScore(score);
        if (gameField[y][x].isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            score = score-5;
            gameOver();
            return;
        }
        if (gameField[y][x].countMineNeighbors == 0) {
            setCellValue(x, y, "");
            for (GameObject go : getNeighbors(gameField[y][x])) openTile(go.x, go.y);
        } else
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
        setCellColor(x, y, Color.GREEN);

        if (countClosedTiles == countMinesOnField) {
            win();
            return;
        }

    }

    private void countMineNeighbors(){
        List<GameObject> list = new ArrayList<GameObject>();
        for (int i=0; i<gameField.length; i++){
            for (int k=0; k<gameField[i].length; k++){
                if (gameField[k][i].isMine!=true){ //если не мина
                    list = getNeighbors(gameField[k][i]);
                    for (GameObject object : list){
                        if(object.isMine){
                            gameField[k][i].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameobject){
        List<GameObject> list = new ArrayList<GameObject>();
        //int i = 0;
        for (int y = gameobject.y - 1; y < gameobject.y + 2; y++){
            for (int x = gameobject.x - 1; x < gameobject.x + 2; x++){
                if ( !((gameobject.x == x ) && (gameobject.y == y)) ){
                    if (( x >= 0 && x < SIDE) && (y >= 0 && y < SIDE)){
                        //setCellNumber(gameobject.x,gameobject.y,i++);
                        list.add(gameField[y][x]);
                    }
                }
            }
        }
        return list;
    }

    private void createGame(){
        boolean putMine = false;

        for(int i = 0; i < SIDE; i++ ){
            for(int j = 0; j < SIDE; j++){
                boolean isMine = (getRandomNumber(10)==0);
                gameField[i][j] = new GameObject(j,i,isMine);
                setCellColor(j,i,Color.ORANGE);
                setCellValue(j,i,"");
                if (isMine)
                    countMinesOnField++;
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Game over!", Color.BROWN, 20);
    }

    private void markTile(int x, int y){    // метод для помечания ячейки флагом
        if (!isGameStopped == true) {       // если игра не остановлена
            if (!gameField[y][x].isOpen && countFlags > 0) { // проверяем что ячейка открыта

                if (!gameField[y][x].isFlag) { // проверяем что есть флаги и ячейка еще не помечена
                    setCellValue(x, y, FLAG); // рисуем на ячейке флаг
                    gameField[y][x].isFlag = true; //помечаем флагом на ячеку
                    setCellColor(x, y, Color.YELLOW);
                    countFlags = countFlags - 1; // уменьшаем количество флагов на единицу


                } else if (gameField[y][x].isFlag) { // если же поле уже помечено флагом то делаем все наоборот

                    gameField[y][x].isFlag = false;//говорим что поле не помечено флагом
                    setCellValue(x, y, "");//стираем флаг и устанавливаем пустую строку
                    setCellColor(x, y, Color.ORANGE);//окрашиваем в исходный цвет
                    countFlags++; //снимаем флаг и увеличиваем количество флагов
                }
            }
        }
    }
}



