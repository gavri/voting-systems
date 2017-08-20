package com.example.gavri.polls

class InstantRunoff(val ballotSheets: List[BallotSheet]) extends Preferential {
  def eliminateWorstCandidate(multiTally: MultiTally) = {
    multiTally.withoutLeastTopRankedCandidate
  }
}

object InstantRunoff {
  def apply(ballotSheets: List[BallotSheet]) = new InstantRunoff(ballotSheets)
}
