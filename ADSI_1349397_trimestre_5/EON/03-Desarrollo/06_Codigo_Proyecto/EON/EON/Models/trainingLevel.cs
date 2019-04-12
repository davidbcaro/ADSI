using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class trainingLevel
    {
        [Key]
        [Display(Name = "idTrainingLevel")]
        public int id_Training_Level { get; set; }

        [Display(Name = "trainingLevel")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(20, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string training_Level { get; set; }

        [Display(Name = "Status")]
        [Required(ErrorMessage = "Field {0} is required")]
        public bool Status { get; set; }

        public virtual ICollection<Program> Programs { get; set; }
    }
}