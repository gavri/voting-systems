package com.example.gavri.polls

class Tally(candidates: List[Candidate]) {
  def breakdown: Map[Candidate, Int] = {
    candidates.groupBy(candidate => candidate).mapValues(_.size)
  }
}

object Tally {
  def apply(candidates: List[Candidate]) = new Tally(candidates)
}
