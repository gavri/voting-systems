package com.example.gavri.polls

class Plurality(candidates: List[Candidate]) extends Election {
  def winners: Set[Candidate] = {
    val tally = Tally(candidates)
    val groupedByNumberOfVotes = tally.breakdown
    val maximumNumberOfVotes = tally.maximumNumberOfVotes
    val candidatesWithMaximumNumberOfVotes = groupedByNumberOfVotes.filter(_._2 == maximumNumberOfVotes).map(_._1)
    candidatesWithMaximumNumberOfVotes.toSet
  }
}

