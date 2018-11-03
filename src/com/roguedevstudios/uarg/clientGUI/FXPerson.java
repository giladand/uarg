package com.roguedevstudios.uarg.clientGUI;

import java.time.LocalDate;

/**
 * Temporary class to help design TableView
 * 
 * @author Marko Bachynsky
 * @since 1.0
 */

public class FXPerson
{
	private String _lastName;
	private String _firstName;
	private LocalDate _date;
	private double _cash;
	private String _city;
	private String _state;

	public FXPerson(String lastName, String firstName, LocalDate date, double cash, String city, String state)
	{
		this._lastName = lastName;
		this._firstName = firstName;
		this._date = date;
		this._cash = cash;
		this._city = city;
		this._state = state;
	}

	public String get_lastName()
	{
		return _lastName;
	}

	public void set_lastName(String _lastName)
	{
		this._lastName = _lastName;
	}

	public String get_firstName()
	{
		return _firstName;
	}

	public void set_firstName(String _firstName)
	{
		this._firstName = _firstName;
	}

	public LocalDate get_date()
	{
		return _date;
	}

	public void set_date(LocalDate _date)
	{
		this._date = _date;
	}

	public double get_cash()
	{
		return _cash;
	}

	public void set_cash(double _cash)
	{
		this._cash = _cash;
	}

	public String get_city()
	{
		return _city;
	}

	public void set_city(String _city)
	{
		this._city = _city;
	}

	public String get_state()
	{
		return _state;
	}

	public void set_state(String _state)
	{
		this._state = _state;
	}


}
