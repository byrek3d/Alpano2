package ch.epfl.alpano;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.epfl.alpano.GeoPoint;
import ch.epfl.alpano.summit.Summit;



/**
 *
 *
 * @author Charline Montial (274902)
 * @author Yves Zumbach (269845)
*/
public class SummitTest {
	GeoPoint eigerPosition = new GeoPoint(Math.toRadians(8.0053),Math.toRadians(46.5775));
	Summit eiger = new Summit("EIGER", eigerPosition, 3970);
	Summit defaultSummit = new Summit("test", new GeoPoint(0, 0), 0);
	
	@Test
	public void testConstructor() {
		new Summit("test", new GeoPoint(0, 0), 0);
	}
	
	@Test
	public void testNameAccessor() {
		assertEquals("EIGER", eiger.getName());
	}
	
	@Test
	public void testElevationAccessor() {
		assertEquals(3970, eiger.getElevation());
	}
	
	@Test
	public void testPositionAccessor() {
		assertEquals(eigerPosition, eiger.getPosition());
	}
	
	@Test
	public void testToString() {
		assertEquals("EIGER (8.0053,46.5775) 3970", eiger.toString());
	}
}