package com.example.gavri.polls

class MultiTally(ballotSheets: List[BallotSheet]) {
  def topRankedCandidates = ballotSheets.map(_.top).flatten

  def withoutLeastTopRankedCandidate = leastTopRankedCandidate map { c =>
    MultiTally(ballotSheets.map { ballotSheet => ballotSheet.withoutCandidate(c) })
  }

  def leastTopRankedCandidate = Tally(topRankedCandidates).leastTopRankedCandidate

  def isEmpty = ballotSheets.forall(_.isEmpty)
}

object MultiTally {
  def apply(ballotSheets: List[BallotSheet]) = new MultiTally(ballotSheets)
}
