using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Tidsplan.Models
{
    public class Trimester
    {

        [Key]
        public int trimesterID { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [MaxLength(20), MinLength(1)]
        [Display(Name = "Nombre del trimestre")]
        public String nameTrimester { get; set; }

        [Required(ErrorMessage = "Es requerido.")]
        [Display(Name = "Nombre del trimestre")]
        public String toUpper
        {
            get
            {
                if (nameTrimester != null)
                {
                    nameTrimester = nameTrimester.ToUpper();
                }
                else
                {
                    nameTrimester = "Es requerido.";
                }
                return nameTrimester;
            }
            set
            {
                if (nameTrimester != null)
                {
                    nameTrimester = nameTrimester.ToUpper();
                }
                else
                {
                    nameTrimester = "Es requerido.";
                }
                nameTrimester.ToUpper();
            }
        }

        public virtual ICollection<Schedule> schedule { get; set; }
   
        public int idTrainingProgram { get; set; }
        public virtual TrainingProgram trainingPrograms { get; set; }

        public int idProjectPhase { get; set; }
        public virtual ProjectPhase projectPhases { get; set; }

        public int idActivities { get; set; }
        public virtual Activity activities { get; set; }

        public int idCompetition { get; set; }
        public virtual Competition competitions { get; set; }

        public int idFormationLvel { get; set; }
        public virtual FormationLevel formationLevels { get; set; }

        public int groupID { get; set; }
        public virtual Group groups { get; set; }

        public int idLearningResults { get; set; }
        public virtual LearningResult learningResults { get; set; }

        public int idProject { get; set; }
        public virtual Project projects { get; set; }
    }
}
