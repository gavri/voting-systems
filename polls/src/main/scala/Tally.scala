package com.example.gavri.polls

class Tally(candidates: List[Candidate]) {
  val breakdown: Map[Candidate, Int] = candidates.groupBy(candidate => candidate).mapValues(_.size)

  val totalNumberOfVotes = candidates.size

  val maximumNumberOfVotes = breakdown.values.max

  def candidatesWithNumberOfVotesMatching(p: Int => Boolean): List[Candidate] = {
    val filtered = breakdown.filter{ case (_, numberOfVotes) => p(numberOfVotes) }
    filtered.keys.toList
  }
}

object Tally {
  def apply(candidates: List[Candidate]) = new Tally(candidates)
}
