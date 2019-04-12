using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Version
    {
        [Key]
        [Display(Name = "idVersion")]
        public int id_Version { get; set; }

        [Display(Name = "Active")]
        public bool Active { get; set; }

        [Display(Name = "Version")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(20, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string version_Name { get; set; }

        public virtual ICollection<Schedule> schedule { get; set; }
        [NotMapped]
        public string FullVersion { get { return string.Format("{0} - {1} ", version_Name, currentQuarters.idcurrent_Quarter); } }

        public int id_current_Quarter { get; set; }
        public virtual currentQuarter currentQuarters { get; set; }  
        
    }
}