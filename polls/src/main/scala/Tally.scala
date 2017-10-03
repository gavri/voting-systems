package com.example.gavri.polls

import scala.util._

class Tally(candidates: List[Candidate]) {
  val breakdown: Map[Candidate, Int] = candidates.groupBy(candidate => candidate).mapValues(_.size)

  val totalNumberOfVotes = candidates.size

  val maximumNumberOfVotes = Try(breakdown.values.max).toOption

  val minimumNumberOfVotes = Try(breakdown.values.min).toOption


  def candidatesWithNumberOfVotesMatching(p: Int => Boolean): List[Candidate] = {
    val filtered = breakdown.filter { case (_, numberOfVotes) => p(numberOfVotes) }
    filtered.keys.toList
  }

  def candidateWithLeastVotes: Option[Candidate] = minimumNumberOfVotes map { n =>
    breakdown.find { case(_, numberOfVotes) => numberOfVotes == n}.get._1
  }

  def candidateWithMostVotes: Option[Candidate] = maximumNumberOfVotes map { n =>
    breakdown.find { case(_, numberOfVotes) => numberOfVotes == n}.get._1
  }
}

object Tally {
  def apply(candidates: List[Candidate]) = new Tally(candidates)
}
