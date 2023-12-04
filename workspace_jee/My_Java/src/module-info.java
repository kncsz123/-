/**
 * 
 */
/**
 * 
 */
module My_Java {
	requires javafx.graphics;
	requires javafx.controls;
	exports gui;
	exports biz;
	opens gui to javafx.graphics;

}