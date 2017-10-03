package com.example.gavri.polls

class MultiTally(ballotSheets: List[BallotSheet]) {
  def topRankedCandidates = ballotSheets.map(_.top).flatten
  def bottomRankedCandidates = ballotSheets.map(_.bottom).flatten

  def withoutLeastTopRankedCandidate = leastTopRankedCandidate map { c =>
    MultiTally(ballotSheets.map { ballotSheet => ballotSheet.withoutCandidate(c) })
  }

  def withoutMostBottomRankedCandidate = mostBottomRankedCandidate map { c =>
    MultiTally(ballotSheets.map { ballotSheet => ballotSheet.withoutCandidate(c) })
  }

  private def leastTopRankedCandidate = Tally(topRankedCandidates).candidateWithLeastVotes
  private def mostBottomRankedCandidate = Tally(bottomRankedCandidates).candidateWithMostVotes

  def isEmpty = ballotSheets.forall(_.isEmpty)
}

object MultiTally {
  def apply(ballotSheets: List[BallotSheet]) = new MultiTally(ballotSheets)
}
