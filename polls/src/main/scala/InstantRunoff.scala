package com.example.gavri.polls

class InstantRunoff(ballotSheets: List[BallotSheet]) extends Election {
  def winner: Option[Candidate] = {
    val multiTally = MultiTally(ballotSheets)
    val iterator = Iterator.iterate(Some(multiTally): Option[MultiTally]) {
      for {
        mt <- _
        mt <- mt.withoutLeastTopRankedCandidate
      } yield mt
    }
    val winnerIterator = for {
      mt <- iterator.flatten.takeWhile(!_.isEmpty)
      winner <- Majority(mt.topRankedCandidates).winner
    } yield winner
    winnerIterator.find(_ => true)
  }

  def winners: Set[Candidate] = winner.toSet
}

object InstantRunoff {
  def apply(ballotSheets: List[BallotSheet]) = new InstantRunoff(ballotSheets)
}
