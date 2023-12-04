/**
 * 
 */
/**
 * 
 */
module My_java {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.swt;
	requires javafx.web;
	exports grid;
	exports exp5.stickman.biz;
	exports exp5.stickman.entity;
	exports exp5.stickman.exception;
	exports exp5.stickman.gui;
	exports exp5.stickman.utils;
	opens grid to javafx.graphics;
}