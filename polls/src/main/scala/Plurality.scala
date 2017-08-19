package com.example.gavri.polls

class Plurality(candidates: List[Candidate]) extends Election {
  def winners: Set[Candidate] = {
    val groupedByNumberOfVotes = Tally(candidates).breakdown
    val maximumNumberOfVotes = groupedByNumberOfVotes.map(_._2).max
    val candidatesWithMaximumNumberOfVotes = groupedByNumberOfVotes.filter(_._2 == maximumNumberOfVotes).map(_._1)
    candidatesWithMaximumNumberOfVotes.toSet
  }
}

