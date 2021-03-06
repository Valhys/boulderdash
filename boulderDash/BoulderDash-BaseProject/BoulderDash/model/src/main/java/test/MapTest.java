package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.Element;
import model.Environment;
import model.IMapGame;
import model.MapGame;

public class MapTest {
	private IMapGame map;
	@Before
	public void setUp() throws SQLException{
		this.map = new MapGame(1);
	}
	@Test
	public void testGetDiamondNumber(){
		int expected = 0;
		assertEquals(expected,map.getDiamondNumber());
	}
	@Test
	public void testSetDiamondNumber(){
		int expected = 2;
		map.setDiamondNumber(expected);
		assertEquals(expected,map.getDiamondNumber());
	}
	@Test
	public void testGetGrid() throws SQLException{
		Element expected = new Element(Environment.WALL);
		assertEquals(expected, this.map.getGrid()[1][1]);
	}
	@Test
	public void testSetGrid(){
		Element expected = new Element(Environment.MUD);
		this.map.setGrid(new Element[1][1]);
		assertEquals(expected, this.map.getGrid()[1][1]);
	}

}
