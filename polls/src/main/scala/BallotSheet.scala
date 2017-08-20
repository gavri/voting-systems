package com.example.gavri.polls

class BallotSheet(candidates: List[Candidate]) {
  def top: Option[Candidate] = candidates.headOption
  def bottom: Option[Candidate] = candidates.lastOption

  def withoutCandidate(candidate: Candidate) = {
    BallotSheet(candidates.filterNot(_ == candidate))
  }

  def isEmpty = candidates.isEmpty
}

object BallotSheet {
  def apply(candidates: List[Candidate]) = new BallotSheet(candidates)
}
