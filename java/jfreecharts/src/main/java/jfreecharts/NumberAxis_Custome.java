/**
 * 
 */
package jfreecharts;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.ui.RectangleEdge;

/**
 * @author ntanwa
 *
 */
public class NumberAxis_Custome extends NumberAxis {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6745430253289869259L;

	protected AxisState drawLabel(String label, Graphics2D g2, Rectangle2D plotArea, Rectangle2D dataArea,
			RectangleEdge edge, AxisState state) {
		return state;
	}
}
