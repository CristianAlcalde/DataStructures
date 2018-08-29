package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cap1.arrays.Matrix;
import cap1.arrays.Vector;

class MatrixTest {

	@Test
	void testInsertar() {
		//Step 1. instantiate the tested class using the constructor method
		Matrix PruebaTama�o =new Matrix  (3,3);
		// Step 2. Create the expected value variable
		int [][] EsperaTama�o =new int[3][3];
		EsperaTama�o[0][0]=4;
		// Step 3. Obtain the actual value
		int[][] ObtenerDato=PruebaTama�o.insertarMatriz(4, 0, 0);
		// Step 4. Compare the expected versus actual values
		assertArrayEquals(EsperaTama�o, ObtenerDato);
			
	}
	@Test
	void testSearchElement() {
		// Step 1. instantiate the tested class using the constructor method
		Matrix PruebaTama�o =new Matrix  (3,3);
		// Step 2. Create the expected value variable
		int EsperaTama�o = 4;
		PruebaTama�o.insertarMatriz(EsperaTama�o, 1, 1);
		// Step 3. Obtain the actual value
		int ObtenerDato = PruebaTama�o.searchElementByPosition(1,1);
		// Step 4. Compare the expected versus actual values
		assertEquals(EsperaTama�o, ObtenerDato);
	}
	@Test
	void testUpdateElement() {
		// Step 1. instantiate the tested class using the constructor method
		Matrix PruebaTama�o = new Matrix  (3,3);
		// Step 2. Create the expected value variable
		int [][] EsperaTama�o =new int[3][3];
		EsperaTama�o[0][0]=6;
		// Step 3. Obtain the actual value
		int[][] ObtenerDato = PruebaTama�o.updateElement(6, 0, 0);
		// Step 4. Compare the expected versus actual values
		assertArrayEquals(EsperaTama�o, ObtenerDato);
	}
	@Test
	void testDeleteElement() {
		// Step 1. instantiate the tested class using the constructor method
		Matrix PruebaTama�o = new Matrix  (3,3);
		// Step 2. Create the expected value variable
		int EsperaTama�o = 4;
		PruebaTama�o.insertarMatriz(EsperaTama�o,1, 1);
		// Step 3. Obtain the actual value
		int[][] ObtenerDato = PruebaTama�o.deleteElement(EsperaTama�o);
		// Step 4. Compare the expected versus actual values
		int pos = PruebaTama�o.searchElementByValue(EsperaTama�o);

		assertEquals(-1, pos);
	}

	@Test
	void testListar() {
		//Step 1. instantiate the tested class using the constructor method
		Matrix PruebaTama�o =new Matrix  (3,3);
		// Step 2. Create the expected value variable
		int [][] EsperaTama�o =new int[3][3];
		EsperaTama�o[0][0]=90;
		// Step 3. Obtain the actual value
		int[][] ObtenerDato=PruebaTama�o.insertarMatriz(90, 0, 0);
		PruebaTama�o.imprimirMatriz();
		// Step 4. Compare the expected versus actual values
		assertArrayEquals(EsperaTama�o, ObtenerDato);
		PruebaTama�o.imprimirMatriz();
		
			

	}
}
