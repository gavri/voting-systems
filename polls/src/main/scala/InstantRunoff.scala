package com.example.gavri.polls

class InstantRunoff(ballotSheets: List[BallotSheet]) extends Election {
  def winner: Option[Candidate] = {
    val multiTally = MultiTally(ballotSheets)
    val iterator = Iterator.iterate(Some(multiTally): Option[MultiTally]) { smt => smt.flatMap {mt => mt.withoutLeastTopRankedCandidate }}
    val winner = iterator.takeWhile{case Some(mt) => !mt.isEmpty; case None => false}.flatMap{smt => smt.map {mt => Majority(mt.topRankedCandidates)}}.flatMap(_.winner).toList.headOption
    winner
  }

  def winners: Set[Candidate] = winner.toSet
}

object InstantRunoff {
  def apply(ballotSheets: List[BallotSheet]) = new InstantRunoff(ballotSheets)
}
