package com.elkammar.thattodo.events;

/**
 * An advantage of having a base interface for events in addition to polymorphism,
 * is to identify scopes when loading the {@link ThatEventManager}, my plan is add 
 * custom annotations and make the {@link ThatEventManager} scan for them and assign
 * each event to it's own scope. An example of different scopes is Async and Syn event buses.
 * Not sure if I will implement this, just wanted to elaborate on the idea.
 * 
 * @author elkammar
 */
public interface IEvent {}
