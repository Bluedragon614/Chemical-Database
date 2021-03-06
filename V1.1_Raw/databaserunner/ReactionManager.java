/*
    ReactionManager.java
    Due Date: January 13, 2019
    Course: ICS4U1
    Teacher: Mrs. Lam
    Description: Stores list of all reactions that have occurred.
*/

package databaserunner;

import java.util.*;

public class ReactionManager {
    
    ///
    //FIELDS
    ///
    
    private List<Reaction> reactionList;
    
    ///
    //ACCESSORS & MUTATORS
    ///
    
    public List<Reaction> getReactionList() {
        return reactionList;
    }
    public void setReactionlist(List<Reaction> reactionList) {
        this.reactionList = reactionList;
    }
    
    ///
    //CONSTRUCTOR
    ///
    
    public ReactionManager() {
        reactionList = new ArrayList();
    }
    
    ///
    //METHODS
    ///
    
    //simulate new Reaction
    public Reaction simulateReaction(Element reactant1, Element reactant2) {
        Reaction newReaction = new Reaction(reactionList.size(), reactant1, reactant2);
        return newReaction;
    }
    
    //add reaction
    public void addReaction(Reaction newReaction){
        this.reactionList.add(newReaction);
    }
    
    //Remove reaction
    public void removeReaction(Reaction reactionToBeRemoved) {
        //remove pointes
        reactionToBeRemoved.removePointers();

        this.reactionList.remove(reactionToBeRemoved);

        //shift IDs back 1 to account for missing item in list
        for (int i = reactionToBeRemoved.getID() ; i < this.reactionList.size() ; i++) {
            Reaction curReaction = this.reactionList.get(i);
            curReaction.setID(curReaction.getID() - 1);
        }
    }
    
    //Searches for specified reaction ID
    public Reaction searchReactionsByID(int id) {
        Reaction curReaction;
        for (int i = 0 ; i < this.getReactionList().size() ; i++) {
            curReaction = this.getReactionList().get(i);
            if (curReaction.getID() == id)
                return curReaction;
        }
        return null;
    } 
}