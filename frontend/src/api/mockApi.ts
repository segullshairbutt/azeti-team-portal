const API_BASE = import.meta.env.VITE_API_BASE

interface TeamStats {
  members: number
  activeProjects: number
  completedThisMonth: number
  efficiency: number
}

interface Activity {
  id: number
  action: string
  timestamp: string
}

export const fetchTeamStats = async (team: string): Promise<TeamStats> => {
  const response = await fetch(`${API_BASE}/teams/${team}/stats`)
  return response.json()
}

export const fetchFeedActivity = async (): Promise<Activity[]> => {
  const response = await fetch(`${API_BASE}/activities/feed`)
  return response.json()
}

export const fetchUserActivity = async (): Promise<Activity[]> => {
  const response = await fetch(`${API_BASE}/users/1/activities`)
  return response.json()
}
