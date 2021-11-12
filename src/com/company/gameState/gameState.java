package com.company.gameState;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/**
 * A gameState is a list of gameStateElements.
 */
public class gameState implements Iterable, Serializable{
    private ArrayList<gameStateElement> saveState = new ArrayList<gameStateElement>();

    /**
     * Adds a new gameStateElemnt with gameStateData and parameter type.
     *
     * @param gameStateData  data for the gameStateElement
     * @param gameStateType the type of the gameStateElement
     */
    public void addGameStateElement(Object gameStateData, String gameStateType){
        gameStateElement newElement = new gameStateElement(gameStateData, gameStateType); {
        saveState.add(newElement);
        }
    }

    public void updateSaveState(ArrayList saveStateList, gameState gs){
        // TODO: allow for multiple types of gameStateElements
        for(int i = 0; i < saveStateList.size(); i++){
            gs.addGameStateElement(saveStateList.get(i), "gameStateElement");
        }
    }

    /**
     * Returns the saveState.
     */
    public ArrayList<gameStateElement> getSaveState(){
        return saveState;
    }
    /**
     * Returns the number of elements in saveState.
     *
     * @return the number of gameStateElements in this gameState.
     */
    public int getSize() {
        return saveState.size();
    }

    /**
     * Returns an iterator for this gameState.
     *
     * @return an iterator for this gameState.
     */
    @Override
    public Iterator<gameStateElement> iterator() {
        return new gameStateElementIterator();
    }

    private class gameStateElementIterator implements Iterator<gameStateElement> {
        private int currentIndex = 0;
        
        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements.
         */
        @Override
        public boolean hasNext() {
            return currentIndex < saveState.size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration.
         */
        @Override
        public gameStateElement next() {
            return saveState.get(currentIndex++);
        }

        /**
         * Removes from the underlying collection the last element returned by the iterator.
         */
        @Override
        public void remove() {
            saveState.remove(currentIndex);
        }
    }
}