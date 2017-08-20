package com.example.gavri.polls

class Coombs(val ballotSheets: List[BallotSheet]) extends Preferential {
  def eliminateWorstCandidate(multiTally: MultiTally) = {
    multiTally.withoutMostBottomRankedCandidate
  }
}

object Coombs {
  def apply(ballotSheets: List[BallotSheet]) = new Coombs(ballotSheets)
}
