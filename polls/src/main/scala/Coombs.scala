package com.example.gavri.polls

case class Coombs(val ballotSheets: List[BallotSheet]) extends Preferential {
  def nextRound(multiTally: MultiTally) = multiTally.withoutMostBottomRankedCandidate
}
