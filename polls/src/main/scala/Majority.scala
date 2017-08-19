package com.example.gavri.polls

class Majority(candidates: List[Candidate]) extends Election {
  def winner: Option[Candidate] = {
    val tally = Tally(candidates)
    val groupedByNumberOfVotes = tally.breakdown
    val maximumNumberOfVotes = tally.maximumNumberOfVotes
    tally.candidatesWithNumberOfVotesMatching(_ > tally.totalNumberOfVotes / 2).headOption
  }

  def winners: Set[Candidate] = Set(winner).flatten
}

