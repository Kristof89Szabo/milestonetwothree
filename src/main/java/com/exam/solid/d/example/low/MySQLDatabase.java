package com.exam.solid.d.example.low;

import com.exam.solid.d.example.mid.Database;

// low level module
public class MySQLDatabase implements Database {

	@Override
	public void connect() {
		System.out.println("Connecting to a MySQL database...");
	}
	
	@Override
	public void disconnect() {
		System.out.println("Disconnecting the MySQL database...");
	}
}