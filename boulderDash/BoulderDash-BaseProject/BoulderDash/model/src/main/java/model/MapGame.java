package model;

import java.sql.SQLException;

import model.dao.BoulderDashBDDConnector;
import view.IElement;

public class MapGame implements IMapGame{
	private IElement grid[][] = new Element[50][50];
	private int diamondNumber = 0;
	private Player player;


	public MapGame(int levelInt) throws SQLException{
		this.generateMap(levelInt);
	}
	public void addElement(int posX, int posY, IElement element){
		this.grid[posX][posY] = element;
	}
	public IElement getElementOfGrid(int posX, int posY){
		return this.grid[posX][posY];
	}
	public IElement[][] getGrid() {
		return this.grid;
	}
	public void setGrid(IElement[][] grid) {
		this.grid = grid;
	}
	public int getDiamondNumber() {
		return diamondNumber;
	}
	public void setDiamondNumber(int diamondNumber) {
		this.diamondNumber = diamondNumber;
	}

	public Player getPlayer(){
		return player;
	}

	public void generateMap(int levelId) throws SQLException{

		int result[] = new int[900];
		int incr = 1;
		BoulderDashBDDConnector connection = new BoulderDashBDDConnector();
		connection.getLevelByLevelId(levelId, result);

		for(int i = 1; i <= 22; i++){
			for(int j = 1; j <= 40; j++){
				Environment tempV = Environment.MUD;
				switch (result[incr]){
				case 1 : tempV = Environment.NOTHING; break;
				case 2 : tempV = Environment.WALL; break;
				case 3 : tempV = Environment.MUD; break;
				case 4 : tempV = Environment.DIAMOND; break;
				case 5 : tempV = Environment.MONSTER; break;
				case 6 : tempV = Environment.ROCK; break;
				case 7 : tempV = Environment.STARTER; break;
				case 8 : tempV = Environment.FINISHER; break;
				}
				try{
					if(result[incr] == 7){
						Element element = new Element(Direction.DOWN);
						this.addElement(j, i, element);
					}
					else{
						Element element = new Element(tempV);
						this.addElement(j, i, element);
					}

				}
				catch(Exception e){
					System.out.println(e);
				}
				incr++;
			}
		}
	}
}
