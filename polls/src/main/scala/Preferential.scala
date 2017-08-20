package com.example.gavri.polls

trait Preferential extends Election {

  def ballotSheets: List[BallotSheet]

  def eliminateWorstCandidate(multiTally: MultiTally): Option[MultiTally]

  def winner: Option[Candidate] = {
    val multiTally = MultiTally(ballotSheets)
    val iterator = Iterator.iterate(Some(multiTally): Option[MultiTally]) {
      for {
        mt <- _
        mt <- eliminateWorstCandidate(mt)
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
