package com.example.gavri.polls

class Plurality(candidates: List[Candidate]) extends Election {
  def winners: Set[Candidate] = {
    val tally = Tally(candidates)
    val groupedByNumberOfVotes = tally.breakdown
    val maximumNumberOfVotes = tally.maximumNumberOfVotes
    maximumNumberOfVotes match {
      case Some(n) => groupedByNumberOfVotes.filter(_._2 == n).map(_._1).toSet
      case None => Set()
    }
  }
}

object Plurality {
  def apply(candidates: List[Candidate]) = new Plurality(candidates)
}

