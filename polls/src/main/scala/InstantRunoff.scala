package com.example.gavri.polls

case class InstantRunoff(val ballotSheets: List[BallotSheet]) extends Preferential {
  def nextRound(multiTally: MultiTally) = multiTally.withoutLeastTopRankedCandidate
}
